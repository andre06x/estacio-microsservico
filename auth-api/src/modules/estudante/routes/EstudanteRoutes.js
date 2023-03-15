import { Router } from "express";
import checkAdmin from "../../../config/auth/checkAdmin.js";
import checkToken from "../../../config/auth/checkToken.js";

import EstudanteController from "../controller/EstudanteController.js";

const router = new Router();

router.post("/api/estudante/auth", EstudanteController.getAccessToken);

router.use(checkToken);

router.get("/api/estudante/email/:email", EstudanteController.findByEmail);

router.use(checkAdmin);

router.post("/api/estudante", EstudanteController.createEstudante);

router.put("/api/estudante/:id", EstudanteController.putEstudante);
// router.delete("/api/estudante/email/:id", EstudanteController.delEstudante);

export default router;
