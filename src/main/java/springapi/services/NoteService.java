package springapi.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapi.entities.Note;
import springapi.repositories.NoteRepository;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note) {
        //normally return response entity
        return noteRepository.save(note);
    }
    //read
    public Note findById(String id) {
        return noteRepository.findById(id);
    }
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
    //update
    public String update(String id, Note note) {
        return noteRepository.update(id, note);
    }

    //delete
    public String delete(String id) {
        return noteRepository.delete(id);
    }

}
