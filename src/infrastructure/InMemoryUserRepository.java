package infrastructure;

import domain.client.User;
import domain.client.UserId;
import domain.client.UserRepository;
import exception.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<UserId, User> data = new ConcurrentHashMap<>();



    @Override
    public UserId nextIdentity() {
        return new UserId(count.incrementAndGet());
    }

    @Override
    public User findById(UserId id) {
        final User user = data.get(id);
        if (user == null) {
            throw NoSuchEntityException.userWithId(id);
        }
        return user;
    }

    @Override
    public void add(User user) {
        data.put(user.getId(), user);

    }

    @Override
    public void delete(UserId id) {
        data.remove(id);
    }

    @Override
    public UserId currentId() {
        return new UserId(count.intValue());
    }


}