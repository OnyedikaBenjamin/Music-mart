// import React, { useEffect } from 'react';
// // import Spotify from 'spotify-player';

// const WebPlayback = () => {

//     useEffect(() => {
//         window.onSpotifyWebPlaybackSDKReady = () => {
//           const token = '[My access token]';
//           const player = new Spotify.Player({
//             name: 'Web Playback SDK Quick Start Player',
//             getOAuthToken: cb => { cb(token); },
//             volume: 0.5
//           });
    
//           // Ready
//           player.addListener('ready', ({ device_id }) => {
//             console.log('Ready with Device ID', device_id);
//           });
    
//           // Not Ready
//           player.addListener('not_ready', ({ device_id }) => {
//             console.log('Device ID has gone offline', device_id);
//           });
    
//           player.addListener('initialization_error', ({ message }) => {
//             console.error(message);
//           });
    
//           player.addListener('authentication_error', ({ message }) => {
//             console.error(message);
//           });
    
//           player.addListener('account_error', ({ message }) => {
//             console.error(message);
//           });
    
//           player.connect();
//         };
//     }, []);

    
//       const handleTogglePlay = () => {
//         const player = new Spotify.Player({});
//         player.togglePlay();
//       };

//   return (
//     <div>
//          <h1>Spotify Web Playback SDK Quick Start</h1>
//         <button onClick={handleTogglePlay}>Toggle Play</button>
//     </div>
//   )
// }

// export default WebPlayback;