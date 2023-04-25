import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import axios from "axios";

const NavBar = () => {

  

 

  const handleYourLibraryClick = () => {
    
    // setTrack(getTrack);

    
  
  }

  
  return (
    
    <div className="navBar">
        <div className="logo">
            <h1>musicmart.</h1>
        </div>
        <ul>
            <li className="active">Home</li>
            {/* <Link to="/WebPlayback"><li>Search</li></Link> */}
            <li>Search</li>
            
            <Link to="/Library"><li onClick={ handleYourLibraryClick }>Your Library</li></Link>
            {/* <a href={`${AUTH_ENDPOINT}?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=${RESPONSE_TYPE}`}>spotify link
            </a> */}
           
            
        </ul>
        <div className="cookies">
            <span>Cookies</span>
            <span>Privacy Policy</span>
        </div>
    </div>
    
  )
}

export default NavBar