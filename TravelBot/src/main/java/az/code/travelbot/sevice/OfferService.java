package az.code.travelbot.sevice;


import az.traveltime.traveltimebot.dto.RequestDto;
import az.traveltime.traveltimebot.models.entity.Answer;
import az.traveltime.traveltimebot.models.entity.Offer;
import az.traveltime.traveltimebot.repo.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class OfferService {



    private final OfferRepo offerRepo;
    SessionService sessionService;
    @Autowired
    OfferService offerService;

    public OfferService(@Lazy SessionService sessionService, OfferRepo offerRepo) {
        this.sessionService = sessionService;
        this.offerRepo = offerRepo;
       // this.rabbitTemplate = rabbitTemplate;
    }


    public void saveOffer(Offer offer) {
        offerRepo.save(offer);
    }


    public Answer sendAnswer(Update update) {
        Long chatId = update.getMessage().getChatId();
        List<Answer> list = sessionService.getByChatId(chatId).getAnswers();
        Answer answer = list.get(list.size() - 1);
        return answer;
    }

    public void sendMessage(Update update) {
        Answer answer = sendAnswer(update);
        RequestDto requestDto = new RequestDto(answer.getRequestId(), answer.getLanguage(),
                answer.getCategory(), answer.getOffer(), answer.getCountryType(), answer.getTravelType(),
                answer.getDestination(), answer.getStartingPoint(), answer.getStartDate(),
                answer.getEndDate(), answer.getWithSomeone(), answer.getBudget());
        //rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, requestDto);
    }
//    public void sendRequestId() {
//
//
//        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, requestDto);
//    }

}
