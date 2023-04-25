package africa.musicmart.data.repositories;

import africa.musicmart.data.model.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
