package pl.zajecia.filmy.api;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.filmy.dao.entity.VideoCassette;
import pl.zajecia.filmy.dao.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cassettes")
public class VideoCassetteApi {
    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
      this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }
    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam long index){
        return videoCassettes.findAllById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }
    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.save(videoCassette);
    }
    @DeleteMapping
    public void deleteVideo(@RequestParam long index){
        videoCassettes.delete(index);
    }
}
