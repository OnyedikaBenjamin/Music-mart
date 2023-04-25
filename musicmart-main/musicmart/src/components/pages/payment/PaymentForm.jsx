import React, { useState } from 'react'
import { useNavigate } from "react-router-dom"
// import { handlePayment } from '../../../routes/paystack/PaystackPayment'

// import Button from "react-bootstrap/Button"
// import "bootstrap/dist/scss/bootstrap.min.scss"
import "../payment/PaymentForm"

import { Button, Form } from 'react-bootstrap';

import 'bootstrap/scss/bootstrap.scss';

import PaystackPop from '@paystack/inline-js';

const PaymentForm = () => {


const navigate = useNavigate();


const [email, setEmail] = useState("")
const [amount, setAmount] = useState("")
const [firstName, setFirstName] = useState("")
const [lastName, setLastName] = useState("")


const payWithPaystack =(e)=>{
    e.preventDefault();

    const allowedAmounts = [200, 400, 500];
    const amountInNairas = parseFloat(amount);

    if (!allowedAmounts.includes(amountInNairas)) {
        alert("Invalid amount. Please choose N200 for Student, N400 for Family or N500 for Individual");
        return;
    }

    const paystack = new PaystackPop()
    paystack.newTransaction({
        key: "pk_test_7cc7226cf3c66dd800bf0a080a67a3a43d1d5e64",
        amount: amount * 100,
        email,
        firstName,
        lastName,
        onSuccess(transaction){
            const message = `Payment Completed! Reference ${transaction.reference}`
            alert(message);
            setEmail("");
            setAmount("");
            setFirstName("");
            setLastName("");
            navigate("/")
        },

        onCancel(){
            alert("You have Cancelled the transaction, close transaction page.")
            navigate("/")
        }
    })
}


    

  return (
    <div>
    

        <div className="musicmart">
            <h1>musicmart.</h1>
        </div>

        <Form id="paymentForm" onSubmit={payWithPaystack} className="custom-form">
            <Form.Group controlId="email">
                <Form.Label>Email Address</Form.Label>
                <Form.Control type="email" value={email} required onChange={(e)=> setEmail(e.target.value)} />
            </Form.Group>
            <Form.Group controlId="amount">
                <Form.Label>Amount</Form.Label>
                <Form.Control type="tel" value={amount} required onChange={(e)=> setAmount(e.target.value)} min="200" max="500" step="100" />
            </Form.Group>
            <Form.Group controlId="firstName">
                <Form.Label>First Name</Form.Label>
                <Form.Control type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
            </Form.Group>
            <Form.Group controlId="lastName">
                <Form.Label>Last Name</Form.Label>
                <Form.Control type="text" value={lastName} onChange={(e) => setLastName(e.target.value)} />
            </Form.Group>
            <br />
            <div className="form-submit">
                <Button type="submit" onClick={payWithPaystack}>Pay</Button>
            </div>
        </Form>
    </div>
  )
}

export default PaymentForm;
