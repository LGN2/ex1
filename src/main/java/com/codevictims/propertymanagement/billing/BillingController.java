package com.codevictims.propertymanagement.billing;
import java.math.BigDecimal; import java.time.LocalDate; import java.util.*; import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api")
public class BillingController {
 record Due(UUID id,UUID leaseId,LocalDate dueMonth,BigDecimal amount,BigDecimal settledAmount,String status){}
 record Payment(UUID id,UUID leaseId,BigDecimal amount,String method,String status,LocalDate receivedAt){}
 record Cheque(UUID id,UUID leaseId,String chequeNumber,BigDecimal amount,LocalDate depositDate,String status){}
 private final Map<UUID,Due> dues=new ConcurrentHashMap<>(); private final Map<UUID,Payment> payments=new ConcurrentHashMap<>(); private final Map<UUID,Cheque> cheques=new ConcurrentHashMap<>();
 @GetMapping("/leases/{leaseId}/dues") public List<Due> dues(@PathVariable UUID leaseId){return dues.values().stream().filter(x->x.leaseId().equals(leaseId)).toList();}
 @PostMapping("/leases/{leaseId}/dues") public ResponseEntity<Due> createDue(@PathVariable UUID leaseId,@RequestBody Map<String,String> body){Due d=new Due(UUID.randomUUID(),leaseId,LocalDate.parse(body.get("dueMonth")),new BigDecimal(body.get("amount")),BigDecimal.ZERO,"UNPAID");dues.put(d.id(),d);return ResponseEntity.status(HttpStatus.CREATED).body(d);}
 @PostMapping("/leases/{leaseId}/payments") public ResponseEntity<Payment> payment(@PathVariable UUID leaseId,@RequestBody Map<String,String> body){Payment p=new Payment(UUID.randomUUID(),leaseId,new BigDecimal(body.get("amount")),body.getOrDefault("method","BANK_TRANSFER"),"SETTLED",LocalDate.now());payments.put(p.id(),p);return ResponseEntity.status(HttpStatus.CREATED).body(p);}
 @GetMapping("/leases/{leaseId}/payments") public List<Payment> payments(@PathVariable UUID leaseId){return payments.values().stream().filter(x->x.leaseId().equals(leaseId)).toList();}
 @GetMapping("/cheques") public Collection<Cheque> cheques(){return cheques.values();}
 @PostMapping("/leases/{leaseId}/cheques") public ResponseEntity<Cheque> cheque(@PathVariable UUID leaseId,@RequestBody Map<String,String> body){Cheque c=new Cheque(UUID.randomUUID(),leaseId,body.get("chequeNumber"),new BigDecimal(body.get("amount")),LocalDate.parse(body.get("depositDate")),"SCHEDULED");cheques.put(c.id(),c);return ResponseEntity.status(HttpStatus.CREATED).body(c);}
 @PostMapping("/cheques/{id}/transitions") public Cheque transition(@PathVariable UUID id,@RequestBody Map<String,String> body){Cheque old=Optional.ofNullable(cheques.get(id)).orElseThrow();Cheque n=new Cheque(old.id(),old.leaseId(),old.chequeNumber(),old.amount(),old.depositDate(),body.get("status"));cheques.put(id,n);return n;}
 @GetMapping("/arrears") public Map<String,Object> arrears(){BigDecimal total=dues.values().stream().map(Due::amount).reduce(BigDecimal.ZERO,BigDecimal::add);BigDecimal paid=payments.values().stream().filter(x->x.status().equals("SETTLED")).map(Payment::amount).reduce(BigDecimal.ZERO,BigDecimal::add);return Map.of("totalDue",total,"totalSettled",paid,"outstanding",total.subtract(paid));}
}