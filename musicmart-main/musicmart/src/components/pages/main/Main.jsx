import React from 'react'
import Card from '../../../reusable-components/cards/Card'
import Categories from "../../pages/categories/Categories"




// const albums = [
//   {
//     id: 1,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 2,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 3,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 4,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 5,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 6,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 7,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 8,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 9,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },

//   {
//     id: 10,
//     imgSrc: "https://images.unsplash.com/photo-1623200693945-ec1e9991039a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
//   },
// ]

const Main = () => {


  return (
    <div className='main'>
        <div className="upperNav">
          
        </div>
        <div className="mainContent">
        <Categories />
         


          
          {/* <div className="cardsWrap">
          <h2>Focus</h2>
            <p className="subText">Music to help you concentrate.</p>
            <div className="cardsWrapInner">
              <div className="card">

                <div className="cardImage">
                    <img src="https://images.unsplash.com/photo-1678649877879-01706b17cd37?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2080&q=80" alt="image1" />
                </div>
                <div className="cardContent">
                    <p>Music for concentration</p>
                    <span>Music to help you concentrate.</span>
                </div>
                <span className="play-icon">
              
                </span>
              </div>
            </div>
          </div> */}
        </div>
    </div>
  )
}

export default Main