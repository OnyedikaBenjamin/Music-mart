import React, { useState, useEffect } from 'react'
import { useForm } from "react-hook-form";
import { useNavigate } from 'react-router-dom';

import axios from 'axios';


import "../login/Login.scss"

import { Form, Button } from 'react-bootstrap';

import 'bootstrap/scss/bootstrap.scss';



const Login = () => {

  const [error, setError] = useState(false);
  // const [isLoggedIn, setIsLoggedIn] = useState(false);

  // const user = JSON.parse(localStorage.getItem('user'));

  const navigate = useNavigate();

    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm();

    // const { reset } = useForm();

    
    
    const url = "http://localhost:8080/api/v1/demo/login"
    
  const login = async (loginData) =>{
      try {
          const res = await axios.post(url, loginData)
          console.log(res);
          setError(false);
          // setIsLoggedIn(false);

          localStorage.setItem('user', JSON.stringify(res.data));

          navigate("/");

      } catch (error) {
        setError(true);
      };
  }

  const onSubmit = (data) => {
    console.log(data);
    
  

    if (!data.email || !data.password) {
      alert("Please sign up as a new user!");
      setError(true);
      return;
    }
      login(data);
   
  };





  return (
    <div className="App">
      <Form onSubmit={handleSubmit(onSubmit)} className="custom-form">
        <Form.Group className="mb-3">
          <Form.Label>Email</Form.Label>
          <Form.Control 
            type="text" 
            name="email" 
            placeholder="Email"
            {...register("email", {
                required: "Email is required.",
                pattern: {
                  value: /^[^@ ]+@[^@ ]+\.[^@ .]{2,}$/,
                  message: "Email is not valid."
                }
            })}
          />
          {errors.email && <Form.Text className="errorMsg">{errors.email.message}</Form.Text>}
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Password</Form.Label>
          <Form.Control 
            type="password" 
            name="password" 
            placeholder="Password"
            {...register("password", {
                required: "Password is required.",
                minLength: {
                  value: 6,
                  message: "Password should be at-least 6 characters."
                }
            })} 
          />
          {errors.password && (
            <Form.Text className="errorMsg">{errors.password.message}</Form.Text>
          )}
        </Form.Group>

        <Button type="submit">Login</Button>
      </Form>

    </div>
  )
}

export default Login;