import React, { useState, useEffect } from 'react'

import { Fragment } from 'react'
import { Outlet, Link } from 'react-router-dom'

import "../navigation/Navigation.scss";

const Navigation = () => {

  const [user, setUser] = useState(null);

  useEffect(() => {
    // Get user data from localStorage
    const userData = localStorage.getItem('user');
    if (userData) {
      setUser(JSON.parse(userData));
    }
  }, []);

  return (
    <Fragment>

      <div className="navigation">

        <Link className="logo-container" to="/">
          <div>Home</div>
        </Link>

       
        
        <div className="links-container">
            {user ? (
                <Fragment>
                  <div className="nav-link">{user.name}</div>
                  <div className="nav-link" onClick={() => {
                    localStorage.removeItem('user');
                    setUser(null);
                    // alert("You have successfully logged out");
                  }}>Logout</div>
                </Fragment>
              ) : (
                <Fragment>
                  <Link className="nav-link" to="/login">
                    Login
                  </Link>
                  <Link className="nav-link" to="/signup">
                    Sign Up
                  </Link>
                </Fragment>
              )}
          <Link className="nav-link" to="/SubscriptionPlan">
              Subscription
          </Link>
        </div>
      </div>
      <Outlet />
    </Fragment>
  )
}

export default Navigation;