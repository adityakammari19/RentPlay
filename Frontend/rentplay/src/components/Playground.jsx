import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
  retriveBookingByUsernameAndPlaygroundIdApi,
  retrivePlaygroundByIdApi,
} from "../services/ApiService";

const Playground = () => {
  const { playgroundId } = useParams();
  // const location = useLocation();
  // const navigate = useNavigate();
  // const { username } = useAuth();
  const username = "aditya";

  const [playground, setPlayground] = useState({});
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    handleRetrivePlaygroundByIdApi();
    handleRetriveBookingByUsernameAndPlaygroundIdApi();
  }, []);

  function handleRetrivePlaygroundByIdApi() {
    // setLoading(true);

    retrivePlaygroundByIdApi(playgroundId)
      .then((response) => {
        setPlayground(response.data);
      })
      .catch((error) => console.log(error))
      .finally(() => {
        // setLoading(false);
        console.log("playground retrived");
      });
  }

  function handleRetriveBookingByUsernameAndPlaygroundIdApi() {
    // setLoading(true);
    retriveBookingByUsernameAndPlaygroundIdApi(username, playgroundId)
      .then((response) => {
        setBookings(response.data);
      })
      .catch((error) => console.log(error))
      .finally(() => {
        // setLoading(false);
        console.log("bookings retrived");
      });
  }

  // const {playgroundName,location,description,pricePerSlot,slotsAvailable}= playground.;

  return (
    <div className="container">
      {/* Playground Details and Slot Booking Section */}
      <div className="row">
        <div className="col-md-3">
          {/* Playground Image */}
          <img
            src={"/playground"}
            alt={playground.playgroundName}
            className="img-fluid"
          />
        </div>
        <div className="col-md-9">
          {/* Playground Details */}
          <h2>{playground.playgroundName}</h2>
          <p>Description: {playground.description}</p>
          <p>Location: {playground.location}</p>
          <p>pricePerSlot: {playground.pricePerSlot}</p>
          <p>Slots Available: {playground.slotsAvailable}</p>
          {/* Book Button */}
          <button className="btn btn-primary">Book</button>
        </div>
      </div>

      {/* Booking History Section */}
      <div className="row mt-4">
        <div className="col">
          <h3>Booking History</h3>
          {/* List of Booking History */}
          <ul className="list-group">
            {bookings.map((booking) => {
              return (
                <li key={booking.bookingId} className="list-group-item">
                  {/* Display Booking History */}
                  {/* You can customize the display of each booking */}
                  {booking.startTime} - {booking.endTime}
                  {booking.status}
                </li>
              );
            })}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Playground;
