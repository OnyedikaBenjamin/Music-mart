import React from 'react'

import "../cards/Card.scss"

const Card = ({imgSrc}) => {

  return (
        
    <div className="card">
        <div className="cardImage">
        <img src={imgSrc} alt="album cover" />
        </div>
        <div className="cardContent">
            <p>Liked songs</p>
        </div>
    </div>
  )
}

export default Card