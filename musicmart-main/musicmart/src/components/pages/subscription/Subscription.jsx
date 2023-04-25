import React, {useState} from 'react'
import { useNavigate } from "react-router-dom"
import PaymentForm from '../payment/PaymentForm';


import { Card, Button } from 'react-bootstrap';

import 'bootstrap/scss/bootstrap.scss';

const Subscription = () => {

    // const[subscription, setSubscription] = useState(false);

    // const navigate = useNavigate();

    // const handleSubmit = (e) => {

    //     e.preventDefault();
    //     setSubscription(true);

    //     navigate("/PaymentForm")
        
    // }

  return (
    <div>
        <h1>List of Subscription Plans</h1>

      

        {/* <PaymentForm /> */}
        {/* <Card>
            <Card.Body>
                <Card.Title>
                    Student Plan
                </Card.Title>

                <Card.Text>
                    Subscription Plans: N500

                    Pay using Paystack
                </Card.Text>

                <Button>Subscribe</Button>

            </Card.Body>
        </Card> */}
    </div>
  )
}

export default Subscription