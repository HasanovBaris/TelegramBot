package az.code.travelbot.repo;


import az.traveltime.traveltimebot.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Message getByKeyAndLang(String  key,String lang);
}
