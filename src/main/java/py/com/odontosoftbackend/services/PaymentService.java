/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.odontosoftbackend.models.Payment;
import py.com.odontosoftbackend.repositories.PaymentRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
        return ((Payment) this.paymentRepository.save(payment));
    }

    public Payment getPaymentById(String id) throws Exception {
        Optional optional = this.paymentRepository.findById(id);
        if (optional.isPresent()) {
            return ((Payment) optional.get());
        }
        throw new Exception("Payment not found!");
    }

    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }

    public void deletePayment(String id) throws Exception {
        if (this.paymentRepository.existsById(id)) {
            this.paymentRepository.deleteById(id);
        } else {
            throw new Exception("Payment not found!");
        }
    }

    public Payment editPayment(Payment payment, String id) {
        payment.setId(id);
        return ((Payment) this.paymentRepository.save(payment));
    }

    public List<Payment> getAllPaymentsByPatientId(String patientId) {
        return this.paymentRepository.findByPatientId(patientId);
    }

}
