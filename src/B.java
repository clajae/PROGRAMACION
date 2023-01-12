class B extends A {

    public String alergias_alimenticias;
    public String alergias_medicamentos;

    public B() {
        super();
    }

    public void dime_alergias_alimenticias(String alergias_alimenticias) {

        if (alergias_alimenticias.equalsIgnoreCase("si")) {
            this.alergias_alimenticias = "si tiene alergias alimenticias";
        } else {
            this.alergias_alimenticias = "no tiene alergias alimenticias";
        }

    }

    public void dime_alergias_medicamentos(String alergias_medicamentos) {

        if (alergias_medicamentos.equalsIgnoreCase("si")) {
            this.alergias_medicamentos = "si tiene alergias a medicamentos";
        } else {
            this.alergias_medicamentos = "no tiene alergias a medicamentos";
        }

    }

    public String dime_alergias() {

        return "El alumno " + alergias_alimenticias + " y " + alergias_medicamentos;

    }

}