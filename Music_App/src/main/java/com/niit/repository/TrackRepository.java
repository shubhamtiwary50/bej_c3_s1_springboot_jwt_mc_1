package com.niit.repository;

import com.niit.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {
    @Query("{'trackRating':{ $gt: 4}}")
    List<Track> findAllTracksFromTrackRating(int trackRating);
    @Query("{'artist.artistName':{$in:[?0]}}")
    List<Track> findAllTracksFromArtistName(String artistName);
}
