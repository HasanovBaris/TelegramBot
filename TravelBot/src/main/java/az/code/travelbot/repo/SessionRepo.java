package az.code.travelbot.repo;

import az.traveltime.traveltimebot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {

    Session findByChatId(Long chatId);
//    Session getByRequestId(double id);


}
