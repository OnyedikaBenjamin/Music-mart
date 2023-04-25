import { Card, ListGroup, ListGroupItem, Button } from 'react-bootstrap';
import { BsCheck } from 'react-icons/bs';
import React, { useNavigate } from "react-router-dom"

function SubscriptionCard({ heading, subheading, benefit1, benefit2, benefit3, buttonText }) {

  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("you clicked me!");
    navigate("/PaymentForm");

  }

  return (
    <Card style={{ width: '20rem', height: '40rem', boxShadow: '0 4px 8px 0 rgba(0,0,0,0.2)' }}>
      <Card.Body className="d-flex flex-column justify-content-center">
        <Card.Title as="h2" style={{ display: 'block', color: "black", marginBottom: '90px' }}>{heading}</Card.Title>
        <Card.Subtitle className="mb-2 text-muted">{subheading}</Card.Subtitle>
        <hr style={{borderColor: 'black'}} />
        <ListGroup className="my-4">
          <ListGroupItem><BsCheck className="text-success mr-2" />{benefit1}</ListGroupItem>
          <ListGroupItem><BsCheck className="text-success mr-2" />{benefit2}</ListGroupItem>
          <ListGroupItem><BsCheck className="text-success mr-2" />{benefit3}</ListGroupItem>
        </ListGroup>
       
        <form  onSubmit={ handleSubmit }>
          <Button 
            // onClick={() => { window.location.href = "/PaymentForm" }}
            type="submit"
            variant="primary" 
            size="md" className="mx-auto bg-black  rounded-pill" 
            style={{ fontWeight: 'bold', fontSize: '14px', padding: "10px", width: "200px" }}
          >
            {buttonText}
          </Button>
        </form>
       

        <p style={{color: 'black', fontSize: '11px', marginTop: "50px"}}>Terms and conditions apply. 1 month free not available for users who have already tried Premium.</p>
      </Card.Body>
    </Card>
  );
}

export default SubscriptionCard;
