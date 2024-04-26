import React from 'react';
import { Link } from 'react-router-dom';

const  PlaygroundCard = ({playground}) =>{

    const {playgroundId,playgroundName,location,description,pricePerSlot}= playground;
    // const { username } = useAuth()
    const username = "aditya"
    return ( 
        <>
         <div className="card" style={{ backgroundColor: 'rgb(196, 223, 223)', color: 'black' }} >
                <div className="row" style={{ height: '300px' }}>
                    <div className="col-md-5">

                        <div className="image-container justify-content-center" style={{ height: '100px' }}>
                            <img src={'/da'} className="card-img-top img-fluid img-responsive" alt={playgroundName} />
                        </div>
                    </div>
                    <div className="col-md-7">
                        <div className="card-body" style={{ borderWidth: 10 }}>
                            <h5 className="card-title">{playgroundName}</h5>
                            <p className="card-text">Location: {location}</p>
                            {/* <p className="card-text">description: {description}</p> */}
                            <p className="card-text">pricePerSlot: {pricePerSlot}</p>

                            <Link className="btn btn-primary align-bottom" to={{ pathname: `/users/${username}/playground/${playgroundId}` }}
                               >View Playground Details</Link>
                        </div>
                    </div>
                </div>
            </div>
        </>
     );
}

export default PlaygroundCard;