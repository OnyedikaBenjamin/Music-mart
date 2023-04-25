import React, { useState, useEffect } from "react";
import Login from "../src/components/pages/login/Login";
import SignUp from "./components/pages/signup/SignUp";

import Home from "../src/components/pages/home/Home"

import { Routes, Route } from "react-router-dom";
import './App.scss';
import Navigation from "./routes/navigation/Navigation";
import Subscription from "./components/pages/subscription/Subscription";
import PaymentForm from "./components/pages/payment/PaymentForm";
import Library from "./components/pages/library/Library";
import SubscriptionPlan from "./components/pages/subscription-plans/SubscriptionPlan";
import WebPlayback from "./components/pages/web-playback/WebPlayback";


function App() {

  const [user, setUser] = useState(null);

  useEffect(() => {
    const userFromLocalStorage = JSON.parse(localStorage.getItem('user'));
    setUser(userFromLocalStorage);
  }, []);

  return (
    // <div className="App">
    //   <Login />
    //   <SignUp />
    // </div>
    <Routes>
      <Route path="/" element={ <Navigation user={user} /> } > 
        <Route index element={ <Home /> }/>
        <Route path="Login" element={ <Login /> }/>
        <Route path="SignUp" element={ <SignUp /> }/>
        <Route path="Subscription" element={ <Subscription /> } />
            {/* <Route path="SubcriptionPlan" element={ <SubscriptionPlan /> } />
          <Route /> */}
        <Route path="PaymentForm" element={ <PaymentForm /> }/>
        <Route path="Library" element={ <Library /> }/>
        <Route path="SubscriptionPlan" element={ <SubscriptionPlan /> }/>
        <Route path="WebPlayback" element={ <WebPlayback /> }/>
        
      </Route>
    </Routes>

  );
}

export default App;
