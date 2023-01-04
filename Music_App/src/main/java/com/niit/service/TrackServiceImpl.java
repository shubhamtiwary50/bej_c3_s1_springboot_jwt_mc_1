package com.niit.service;

import com.niit.domain.Track;
import com.niit.exception.TrackNotFoundException;
import com.niit.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{


    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrackData() throws TrackNotFoundException {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        boolean result = false;
        if(trackRepository.findById(trackId).isEmpty()){
            throw new TrackNotFoundException();
        }else{
            trackRepository.deleteById(trackId);
            result = true;
        }
        return result;
    }

    @Override
    public List<Track> getAllTrackByTrackRating(int trackRating) throws TrackNotFoundException {
        if(trackRepository.findAllTracksFromTrackRating(trackRating).isEmpty()){
            throw  new TrackNotFoundException();
        }
        return trackRepository.findAllTracksFromTrackRating(trackRating);
    }

    @Override
    public List<Track> getAllTrackByArtistName(String artistName) throws TrackNotFoundException {
        if(trackRepository.findAllTracksFromArtistName(artistName).isEmpty()){
            throw  new TrackNotFoundException();
        }
        return trackRepository.findAllTracksFromArtistName(artistName);
    }


}
