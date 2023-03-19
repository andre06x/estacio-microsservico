import express, { json } from "express";
import * as db from "./src/config/db/initialData.js";
import estudanteRoutes from "./src/modules/estudante/routes/EstudanteRoutes.js";
const app = express();
const env = process.env;
const PORT = env.PORT || 8080;

db.createInitialData();

app.get("/api/status", (req, res) => {
  return res.status(200).json({
    service: "Auth-API",
    status: "up",
    httpStatus: 200,
  });
});

app.use(json());
app.use(estudanteRoutes);

app.listen(PORT, () => {
  console.info(`server iniciou na porta ${PORT}`);
});
