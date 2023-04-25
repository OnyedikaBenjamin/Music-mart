import { Navbar, Nav, NavDropdown, Image, Container, Button } from 'react-bootstrap';
import SubscriptionCard from '../../../reusable-components/subscription-cards/SubscriptionCard';

import React from "react"

const SubscriptionNavbar = () => {
  return (
    <div>
        <Navbar bg="light" expand="lg" style={{ backgroundColor: '#040404' }}>
          <Navbar.Brand href="#home">
            <img
              src="/logo.png"
              width="30"
              height="30"
              className="d-inline-block align-top"
              alt="My Logo"
            />
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">

      
            <Nav className="d-flex justify-content-end" style={{ width: "95%" }}>
              <Nav.Link href="#">Premium</Nav.Link>
              <Nav.Link href="#">Support</Nav.Link>
              <Nav.Link href="#">Download</Nav.Link>
              <NavDropdown title={<Image src="/avatar.png" roundedCircle />} id="basic-nav-dropdown">
                <NavDropdown.Item href="#">Profile</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#">Logout</NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Navbar>

      <Container fluid style={{ height: '20rem', backgroundColor: '#1d75de' }}>
          <div className="d-flex flex-column align-items-flex-start justify-content-center h-100 mt-auto">
            <h2 className="text-white text-center mb-3">Get premium free for 1 month</h2>
            <p className="text-white text-center mb-4">Just for N900/month after. Cancel anytime.</p>
            <div className="d-flex justify-content-center">
              <Button variant="dark" size="lg" className="mr-2" style={{backgroundColor: 'black'}}>GET STARTED</Button>
              <Button variant="outline-light" size="lg">VIEW PLANS</Button>
            </div>
          </div>
      </Container>

    </div>
  );
}
export default SubscriptionNavbar;