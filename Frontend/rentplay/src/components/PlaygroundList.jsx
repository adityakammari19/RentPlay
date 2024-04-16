import React from 'react'

function PlaygroundList({playgrounds}) {
    return (<>
        <div>PlaygroundList</div>
        <div className="row p-5">
        {playgrounds.map((playground) => {
          return (
            <div
              className="col-md-6 col-lg-4 mb-3 ml-3 shadow p-3"
              style={{ justifyContent: "space-between" }}
              key={playground.playgroundId}
            >
              <div>{playground.playgroundName}</div>
              {console.log(playground)}
            </div>
          );
        })}
      </div>
</>
    )
}

export default PlaygroundList