import { Link } from "react-router-dom";
import ArrowIcon from "../../assets/imgs/arowIcon.svg";
import "./styles.css";
import { Game } from "../../types/Game";
import { useEffect, useState } from "react";
import axios from "axios";
import { BASE_URL } from "../../utils/request";

const GameDetails = () => {
  const [game, setGame] = useState<Game>();

  useEffect(() => {
    axios.get(BASE_URL + "/api/games/2").then((response) => {
      setGame(response.data);
    });
  }, []);
  return (
    <div className="game-details-container">
      <div className="game-details-card">
        <Link to="/library">
          <div className="goback-container">
            <img src={ArrowIcon} alt="" />
            <h2>VOLTAR</h2>
          </div>
        </Link>

        <div className="row">
          <div className="col-xl-7">
            <div className="img-container">
              <img src={game?.imgUrl} alt="" />
            </div>
            <div className="info-game-container">
              <h1>
                Nome: <span>{game?.name}</span>
              </h1>
              <h1>
                Plataforma: <span>{game?.platform}</span>
              </h1>
              <h1>
                Nota: <span className="grade-details">{game?.grade}</span>
              </h1>
            </div>
          </div>
          <div className="col-xl-5">
            <div className="review-container">
              <h2>REVIEW</h2>
              <p>{game?.review}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default GameDetails;
