package az.code.travelbot.sevice;


import az.traveltime.traveltimebot.models.entity.Answer;
import az.traveltime.traveltimebot.repo.AnswerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepo answerRepo;
    public List<Answer> getAllAnswer(){
        return answerRepo.getAll();
    }
    public Answer getByRequestId(Long id){
        return answerRepo.getByRequestId(id);
    }

}
