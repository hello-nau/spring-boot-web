package springapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springapi.entities.Note;
import springapi.services.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins="*")
public class NoteController {
    @Autowired
    NoteService noteService;
    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.save(note));
    }
    @GetMapping("{id}")
    public ResponseEntity<Note> findById(@PathVariable(value= "id") String id) {
        Note note = noteService.findById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> update(@PathVariable(value = "id") String id, @RequestBody Note updatedNote) {
        Note existingNote = noteService.findById(id);
        if (existingNote != null) {
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());

            Note updated = noteService.save(existingNote);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        //in production offset it into the service
        return ResponseEntity.ok(noteService.delete(id));
    }
}
