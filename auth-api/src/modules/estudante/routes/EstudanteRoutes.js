import { Router } from "express";
import checkToken from "../../../config/auth/checkToken.js";

import EstudanteController from "../controller/EstudanteController.js";

const router = new Router();

router.post("/api/estudante/auth", EstudanteController.getAccessToken);
router.post("/api/estudante", EstudanteController.createEstudante);

router.use(checkToken);

router.get("/api/estudante/email/:email", EstudanteController.findByEmail);

export default router;
