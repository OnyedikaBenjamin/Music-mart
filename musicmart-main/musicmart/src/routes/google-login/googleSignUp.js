import { useEffect, useState } from "react";
import { google, GoogleLogin } from "react-google-login";

import jwt_decode from "jwt-decode";

import { Button } from 'react-bootstrap';

import 'bootstrap/scss/bootstrap.scss';



const GoogleSignUp = () => {

    const client =  "115080498014-ni0cgtm8v4puuvhsev1v395lrem5b855.apps.googleusercontent.com"

    const [ user, setUser ] = useState({});

    // const clientId = "424483526692-muhblov1snhppbi16bkt5ubkcruh2md5.apps.googleusercontent.com"
  

    const handleGoogleSuccess = (response) => {
        console.log("Encoded JWT ID token: " + response.credential); // Handle successful Google sign up
        let userObject = jwt_decode(response.credential);
        console.log(userObject);
        setUser(userObject);
        document.getElementById("signInDiv").hidden = true;
    };
      
    const handleGoogleFailure = (response) => {
        console.log(response); // Handle Google sign up failure
    };

    // const handleSignOut = (event) =>{
    //     setUser({});
    //     document.getElementById("signInDiv").hidden = false;
    // }
 
    // useEffect(()=>{
    //     /* global google */

    //     google.accounts.id.initialize({
    //         client_id: "115080498014-ni0cgtm8v4puuvhsev1v395lrem5b855.apps.googleusercontent.com",
    //         callback: handleGoogleSuccess
    //     });

    //     google.accounts.id.renderButton(
    //         document.getElementById("signInDiv"),
    //         { theme: "outline", size: "large" }
    //     );


    // }, [])

    return(
        <div >
            <GoogleLogin
                clientId={ client }
                buttonText="Sign up with Google"
                onSuccess={handleGoogleSuccess}
                onFailure={handleGoogleFailure}
                cookiePolicy={'single_host_origin'}
            />

    


            <div id="signInDiv"></div>
            {
                Object.keys(user).length !== 0
            }

            {
                 user &&
                 <div>
                    <img src={ user.picture } alt="profile" />
                    <h3>{ user.name }</h3>
                </div>
            }

            <Button variant="danger">Sign Out</Button>
            
        </div>
    )
}

export default GoogleSignUp;
