@RestController
@RequestMapping("/api")
public class SongController {
    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }
}

@RequestMapping(value = "/init-db", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
public String fillDatabase() {
    Song song1 = new Song();

    song1.setAuthor("Bigflo & Oli");
    song1.setAlbum("La vie de rêve");
    song1.setTitle("Bienvenue chez moi");
    song1.setRate(4);

    Song song2 = new Song();

    song2.setAuthor("Mathieu Chédid");
    song2.setAlbum("Je dis aime");
    song2.setTitle("Monde virtuel");
    song2.setRate(3);

    Song song3 = new Song();

    song3.setAuthor("Lee fields");
    song3.setAlbum("Faithful Man");
    song3.setTitle("Wish you were here");
    song3.setRate(5);

    this.songRepository.save(song1);
    this.songRepository.save(song2);
    this.songRepository.save(song3);

    return "Database has been filled in !";
}