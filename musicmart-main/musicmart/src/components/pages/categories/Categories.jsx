import React, { useState, useEffect } from "react"
import { ReactComponent as PlayIcon } from "../../assets/play.svg";
import { Card, Container, Row, Col } from "react-bootstrap";
import axios from "axios";



const Categories = () => {

    // const [tracks, setTracks] = useState([]);

    // useEffect(() => {

    //     const headers = {
    //         Authorization: `Bearer ${"BQAknMQaXj1tlWyhFsm2qb-R62qY53c5ZlPPWB4qx6Nm2V1kURhwOdq6Orp_08_K876os_TFodQMST_mK_aL7-Hwp1ruaPUbKzU-E8nPr4qHl78I5PVO"}`,
    //       };
    //   const fetchTracks = async () => {
    //     const response = await axios.get(
    //         "https://api.spotify.com/v1/tracks",
    //         {
    //           headers: headers,
    //           params: {
    //             ids: "0eGsygTp906u18L0Oimnem,6rqhFgbbKwnb9MLmUQDhG6,7KXjTSCq5nL1LoYtL7XAwS",
    //             market: "NG"
    //           }
    //         }
    //     );
    //     setTracks(response.data.tracks);
    //     console.log(response);
    //   };
  
    //   fetchTracks();
    // }, []);



    return(
    <div>
         <div className="cardsWrap">
          
          <h2>Uniquely yours</h2>


            <div className="card">
              <div className="cardImage">
                  <img src="https://images.unsplash.com/photo-1678649877879-01706b17cd37?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2080&q=80" alt="image1" />
              </div>
              <div className="cardContent">
                  <p>Liked songs</p>
              </div>
            <span className="play-icon">
              <PlayIcon />
            </span>
            </div>
        </div>


        <div className="cardsWrap">
          
          <h2>Uniquely yours</h2>


            <div className="card">
              <div className="cardImage">
                  <img src="https://images.unsplash.com/photo-1680169258027-3677d4c8e4f5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyN3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60" alt="image1" />
              </div>
              <div className="cardContent">
                  <p>Liked songs</p>
              </div>
            <span className="play-icon">
              <PlayIcon />
            </span>
            </div>
        </div>


        <div className="cardsWrap">
          
          <h2>Uniquely yours</h2>


            <div className="card">
              <div className="cardImage">
                  <img src="https://images.unsplash.com/photo-1680252112129-91e7840cba38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80" alt="image1" />
              </div>
              <div className="cardContent">
                  <p>Liked songs</p>
              </div>
            <span className="play-icon">
              <PlayIcon />
            </span>
            </div>
        </div>

        {/* <div className="cardsWrap">
                <h2>Uniquely yours</h2>
                {tracks.map((track, index) => (
                <div className="card" key={index}>
                    <div className="cardImage">
                    <img src={track.album.images[0].url} alt={track.name} />
                    </div>
                    <div className="cardContent">
                    <p>{track.name}</p>
                    <p>{track.artists[0].name}</p>
                    </div>
                    <span className="play-icon">
                    <PlayIcon />
                    </span>
                </div>
                ))}
            </div> */}


            {/* <Container>
      <h2>Uniquely yours</h2>
      <Row className="cardsWrap">
        {tracks.map((track, index) => (
          <Col md={3} key={index}>
            <Card>
              <Card.Img variant="top" src={track.album.images[0].url} alt={track.name} />
              <Card.Body>
                <Card.Title>{track.name}</Card.Title>
                <Card.Text>{track.artists[0].name}</Card.Text>
                <span className="play-icon">
                  <PlayIcon />
                </span>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container> */}
           
    </div>
    );
}
export default Categories;