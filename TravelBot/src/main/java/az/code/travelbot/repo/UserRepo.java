package az.code.travelbot.repo;

import az.traveltime.traveltimebot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User getByChatId(Long id);

}
