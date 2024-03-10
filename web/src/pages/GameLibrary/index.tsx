import GameCard from "../../components/GameCard";

const GameLibrary = () => {
  return (
    <div className="library-container container my-4">
      <div className="library-title-container row">
        <h1>Minha Biblioteca</h1>
      </div>

      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <GameCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <GameCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <GameCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <GameCard />
        </div>
      </div>
    </div>
  );
};

export default GameLibrary;
