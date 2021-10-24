package homework_6;

public class State {
    private String capitol;
    private int population;

    public State(String capitol, int pop) {
        this.capitol = capitol;
        this.population = pop;
    }

    public String getCapitol() {
        return capitol;
    }

    public int getPopulation() {
        return population;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}