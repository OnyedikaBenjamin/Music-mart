import React from 'react'
import SubscriptionNavbar from '../subscription-navbar/SubscriptionNavbar';
import SubscriptionCard from '../../../reusable-components/subscription-cards/SubscriptionCard';
import SubscriptionFooter from "../../../reusable-components/subscription-cards/SubscriptionFooter" 

import { Container, Row, Col, Card } from 'react-bootstrap';

const SubscriptionPlan = () => {

  const cardData = [
    {
      heading: 'Student',
      subheading: 'N200/month after offer period 1 account',
      benefit1: 'AD-free music listening',
      benefit2: 'Play anywhere',
      benefit3: 'Play songs in any order',
      buttonText: 'GET STARTED'
    },
    {
      heading: 'Family',
      subheading: 'N400/month after period 2 accounts',
      benefit1: '6 premium accounts for family members living under one roof',
      benefit2: 'Block explicit music',
      benefit3: 'AD-free music listening',
      benefit4: 'Play songs in any order',
      buttonText: 'GET STARTED'
    },
    {
      heading: 'Individual',
      subheading: 'N500/month after period 1 account',
      benefit1: 'Download songs on the go',
      benefit2: 'Select different genres',
      benefit3: 'Get premium sound quality ',
      benefit4: 'Get song lyrics on the go',
      buttonText: 'GET STARTED'
    }
  ];
  return (
    <div>
      <SubscriptionNavbar />
      <div style={{ height: '40%', width: '100%', backgroundColor: '#efefef' }}>
      <Container className="h-100 d-flex align-items-center justify-content-center">
        <Row className="justify-content-center">
          {cardData.map((card, id) => (
            <Col key={id} md={4} className="my-4">
             
              <SubscriptionCard
                heading={card.heading}
                subheading={card.subheading}
                benefit1={card.benefit1}
                benefit2={card.benefit2}
                benefit3={card.benefit3}
                benefit4={card.benefit4}
                buttonText={card.buttonText}
              />
            </Col>
          ))}
        </Row>
      </Container>
    </div>
      <SubscriptionFooter />
    </div>
  )
}

export default SubscriptionPlan;