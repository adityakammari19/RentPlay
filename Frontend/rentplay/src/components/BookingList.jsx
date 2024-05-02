import React from 'react'

function BookingList({bookings}) {
    return (<>
        <div>BookingList</div>
        <div className="row p-5">
        {bookings.map((booking) => {
          return (
            <div
              className="col-md-6 col-lg-4 mb-3 ml-3 shadow p-3"
              style={{ justifyContent: "space-between" }}
              key={booking.bookingId}
            >
               {/* <div>{booking.bookingId}</div> */}
                    <div>{booking.playgroundId}</div>
                    <div>{booking.startTime}</div>
                    <div>{booking.endTime}</div>
                    <div>{booking.status}</div>
              {console.log(booking)}
            </div>
          );
        })}
      </div>
      </>
    )
}

export default BookingList