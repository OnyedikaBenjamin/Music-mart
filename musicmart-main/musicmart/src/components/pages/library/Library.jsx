import React, { useEffect, useState } from 'react'
import Dropdown from '../../../reusable-components/dropdown/Dropdown'
import Credentials from '../../../routes/credentials/Credentials'
import ListBox from '../listBox/ListBox'
import Detail from '../details/Details'
import axios from 'axios'


import "../library/Library.scss"

const Library = () => {
    const spotify = Credentials();

    const [ token, setToken ] = useState("");
    const [ genres, setGenres ] = useState({selectedGenre: "", listOfGenresFromAPI: []});
    const [playlist, setPlaylist] = useState({selectedPlaylist: '', listOfPlaylistFromAPI: []});
    const [tracks, setTracks] = useState({selectedTrack: '', listOfTracksFromAPI: []});
    const [trackDetail, setTrackDetail] = useState(null);



    // const data = [
    //     {value: 1, name: "A"},
    //     {value: 2, name: "B"},
    //     {value: 3, name: "C"}
    // ]



    useEffect(()=> {
        axios("https://accounts.spotify.com/api/token", {
            headers: {
               
                "Content-Type": "application/x-www-form-urlencoded",
                "Authorization": `Basic ` + btoa(spotify.CLIENT_ID + ":" + spotify.CLIENT_SECRET)
            },
            data: "grant_type=client_credentials",
            method: "POST"
        })
        .then(tokenResponse => {
            console.log(tokenResponse.data.access_token);
            setToken(tokenResponse.data.access_token);

            axios("https://api.spotify.com/v1/browse/categories?locale=sv_US", {
                method: "GET",
                headers: { "Authorization" : "Bearer " + tokenResponse.data.access_token}
            })
            .then (genreResponse => {
                setGenres({
                    selectedGenre: genreResponse.selectedGenre,
                    listOfGenresFromAPI: genreResponse.data.categories.items
                });
            });
        });
    }, [genres.selectedGenre, spotify.CLIENT_ID, spotify.CLIENT_SECRET]);
  

    const genreChanged = val => {
        setGenres({
            selectedGenre: val,
            listOfGenresFromAPI: genres.listOfGenresFromAPI
        });

        axios( `https://api.spotify.com/v1/browse/categories/${val}/playlists?limit-10`, {
            method: 'GET',
            headers: {"Authorization" : "Bearer " + token}
        })
        .then(playlistResponse => {
            setPlaylist({
                selectedPlaylist: playlist.selectedPlaylist,
                listOfPlaylistFromAPI: playlistResponse.data.playlists.items
            })
        });

        console.log(val)
    }

    const playlistChanged = val => {
        console.log(val);
        setPlaylist({
            selectedPlaylist: val,
            listOfPlaylistFromAPI: playlist.listOfPlaylistFromAPI
        })
    }

    const buttonClicked = e => {
        e.preventDefault();

        axios(`https://api.spotify.com/v1/playlists/${playlist.selectedPlaylist}/tracks?limit=10`, {
            method: 'GET',
            headers: {
                'Authorization' : "Bearer " + token
            }
        })
        .then(tracksResponse => {
            setTracks({
                selectedTrack: tracks.selectedTrack,
                listOfTracksFromAPI: tracksResponse.data.items
            })
        })
    }

    const listBoxClicked = val => {
        const currentTracks = [...tracks.listOfTracksFromAPI];

        const trackInfo = currentTracks.filter(t => t.track.id === val );

        setTrackDetail(trackInfo[0].track);
    }




  return (
   
    <form onSubmit={buttonClicked} className="library">        
        <Dropdown label="Genre :" options={genres.listOfGenresFromAPI} selectedValue={genres.selectedGenre} changed={genreChanged} />
        <Dropdown label="Playlist :" options={playlist.listOfPlaylistFromAPI} selectedValue={playlist.selectedPlaylist} changed={playlistChanged} />
        <div className="col-sm-6 row form-group px-0">
        <button type='submit' className="btn btn-success col-sm-12">
            Search
        </button>
        </div>
        <div className="row">
        <ListBox items={tracks.listOfTracksFromAPI} clicked={listBoxClicked} />
        {trackDetail && <Detail {...trackDetail} /> }
        </div>        
    </form>
  )
}

export default Library;