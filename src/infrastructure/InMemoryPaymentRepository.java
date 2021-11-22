package infrastructure;

import domain.client.UserId;
import domain.tradesman.PaymentId;
import domain.tradesman.PaymentRepository;
import domain.tradesman.PaymentTransaction;
import exception.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPaymentRepository implements PaymentRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<PaymentId, PaymentTransaction> data = new ConcurrentHashMap<>();


    @Override
    public PaymentId nextIdentity() {
        return new PaymentId(count.incrementAndGet());
    }

    @Override
    public PaymentTransaction findById(PaymentId id) throws NoSuchEntityException {
        final PaymentTransaction transcation = data.get(id);
        if (transcation == null) {
            throw NoSuchEntityException.paymentWithId(id);
        }
        return transcation;
    }

    @Override
    public void add(PaymentTransaction entity) {
    }

    @Override
    public void delete(PaymentId id) {
    }

    @Override
    public UserId currentId() {
        return null;
    }
}