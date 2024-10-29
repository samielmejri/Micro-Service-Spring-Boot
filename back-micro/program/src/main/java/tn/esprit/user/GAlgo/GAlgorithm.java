package tn.esprit.user.GAlgo;

import tn.esprit.user.dto.program.ClassDTO;
import tn.esprit.user.entities.schedule.ElementModule;
import tn.esprit.user.entities.schedule.Modul;
import tn.esprit.user.entities.schedule.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tn.esprit.user.services.Implementations.DataFromDB;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GAlgorithm {
    private static final Logger LOGGER = LoggerFactory.getLogger(GAlgorithm.class);
    private  final int POPULATION_SIZE = 10;
    private  final double MUTATION_RATE = 0.2;
    private  final double CROSSOVER_RATE = 0.9;
    private  final int MAX_GENERATIONS = 50;
    Period[] timeslots;
    List<DayOfWeek> days;

    private   final int targetFitness = 1;
    Random random = new Random();
    private List<UniversityTimetable> population;
    private boolean isTerminated;
    public GAlgorithm() {
        this.population = new ArrayList<>(POPULATION_SIZE);
        this.isTerminated = false;

        timeslots = Period.values();
        days = new ArrayList<>();
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.TUESDAY);
        days.add(DayOfWeek.WEDNESDAY);
        days.add(DayOfWeek.THURSDAY);
        days.add(DayOfWeek.FRIDAY);
    }
    private DayOfWeek getRandomDay() {
        int index = random.nextInt(days.size());
        return days.get(index);
    }
    private Period getRandomPeriode(DayOfWeek day) {
        // if day equal wednesday and periode equal P3 or P4 then rgenerate periode
        if (day.equals(DayOfWeek.WEDNESDAY)) {
            int index = random.nextInt(timeslots.length);
            while (timeslots[index].equals(Period.P3) || timeslots[index].equals(Period.P4)) {
                index = random.nextInt(timeslots.length);
            }
            return timeslots[index];
        }
        else {
            int index = random.nextInt(timeslots.length);
            return timeslots[index];
        }
    }
    private List<ElementModule> getElementsForClasse(String className) {
        List<ElementModule> elementModules = new ArrayList<>();
        for (ElementModule element : elementModules) {
            if (element.getClasses().contains(className)) {
                elementModules.add(element);
            }
        }
        return elementModules;
    }

    private List<ElementModule> getElementsForClasse(ClassDTO classe) {
            List<ElementModule> elementModules = new ArrayList<>();
            if (classe != null && classe.getModuls() != null) {
                for (Modul modul : classe.getModuls()) {
                    if (modul != null && modul.getElementModules() != null) {
                        elementModules.addAll(modul.getElementModules());
                    } else if (modul == null) {
                        System.out.println("One of the Modul objects in the class is null.");
                    } else {
                        System.out.println("Modul " + modul.getName() + " does not have any ElementModule objects associated with it.");
                    }
                }
            } else if (classe == null) {
                System.out.println("The Class object passed to the method is null.");
            } else {
                System.out.println("Class " + classe.getName() + " does not have any Modul objects associated with it.");
            }
            return elementModules;
        }
    public void initializePopulation() {
        LOGGER.info("Initializing population...");
        for (int i = 0; i < POPULATION_SIZE; i++) {
            UniversityTimetable universityTimetable = new UniversityTimetable(DataFromDB.classes.size());
            for (int classIndex = 0; classIndex < DataFromDB.classes.size(); classIndex++) {
                ClassDTO classe = DataFromDB.classes.get(classIndex);
                List<ElementModule> elements = getElementsForClasse(classe);
                Collections.shuffle(elements);
                for (ElementModule element : elements) {
                    if (element != null) {
                        DayOfWeek day = getRandomDay();
                        Period periode = getRandomPeriode(day);
                        element.setDayOfWeek(day);
                        element.setPeriod(periode);
                        universityTimetable.addElementDeModule(classIndex, element);
                    } else {
                        System.out.println("One of the ElementModule objects in the class is null.");
                    }
                }
            }
            population.add(universityTimetable);
        }
    }
    public void printTimetable(UniversityTimetable universityTimetable) {
        System.out.println("SchoolTimetable with fitness : " + universityTimetable.getFitness() + " %");
        for (int classIndex = 0; classIndex < universityTimetable.getNumberOfClasses(); classIndex++) {
            System.out.println("Class " + universityTimetable.getTimetable(classIndex).get(0).getModul().getAClass().getName() + ":");
            List<ElementModule> classTimetable = universityTimetable.getTimetable(classIndex);
            System.out.println("classTimetable size " + classTimetable.size());
            for (ElementModule element : classTimetable) {
                String day = element.getDayOfWeek().toString();
                String period = element.getPeriod().toString();
                String module = element.getModul().getName();

                System.out.println("Day: " + day + ", Period: " + period + ", Room: "  + module + ", Teacher: " + element.getTeacher().getProfile().getName() + " Element: " + element.getName());
            }
            System.out.println();
        }
    }
    public void evolve() {
        LOGGER.info("Starting evolution...");
        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            List<UniversityTimetable> newPopulation = new ArrayList<>(POPULATION_SIZE);

            for (int j = 0; j < POPULATION_SIZE / 2; j++) {
                UniversityTimetable parent1 = selectParent();
                UniversityTimetable parent2 = selectParent();

                if (random.nextDouble() <= CROSSOVER_RATE) {
                    List<UniversityTimetable> children = crossover(parent1, parent2);

                    if (random.nextDouble() <= MUTATION_RATE) {
                        mutate(children.get(0));
                    }
                    if (random.nextDouble() <= MUTATION_RATE) {
                        mutate(children.get(1));
                    }

                    newPopulation.add(children.get(0));
                    newPopulation.add(children.get(1));
                } else {
                    newPopulation.add(parent1);
                    newPopulation.add(parent2);
                }
            }
            // Calculate fitness for the new population
            for (UniversityTimetable universityTimetable : newPopulation) {
                universityTimetable.calculateFitness();
            }

            population = newPopulation;

            System.out.println("Generation " + generation + " with population size: " + population.size());
            for (UniversityTimetable universityTimetable : population) {
                System.out.println(universityTimetable .getFitness());
            }

            // Termination condition based on fitness threshold or lack of improvement
            if ( getBestTimetable().getFitness() <= targetFitness) {
                isTerminated = true;
                break;
            }
        }
    }
    public UniversityTimetable getBestTimetable() {
        // if (isTerminated) {
        UniversityTimetable bestUniversityTimetable = population.get(0);
        double bestFitness = bestUniversityTimetable.calculateFitness();

        for (int i = 1; i < POPULATION_SIZE; i++) {
            UniversityTimetable currentUniversityTimetable = population.get(i);
            double currentFitness = currentUniversityTimetable.calculateFitness();

            if (currentFitness < bestFitness) {
                bestUniversityTimetable = currentUniversityTimetable;
                bestFitness = currentFitness;
            }
        }

        return bestUniversityTimetable;
       /* } else {
            throw new IllegalStateException("Algorithm has not terminated yet.");
        }*/
    }
    private UniversityTimetable selectParent() {

        int totalFitness = 0;
        for (UniversityTimetable universityTimetable : population) {
            totalFitness += universityTimetable.calculateFitness();
        }

        int randomFitness = 0;
        if (totalFitness > 0) {
            randomFitness = random.nextInt(totalFitness);
        }
        int cumulativeFitness = 0;

        for (UniversityTimetable universityTimetable : population) {
            cumulativeFitness += (totalFitness - universityTimetable.calculateFitness());
            if (cumulativeFitness > randomFitness) {
                return universityTimetable;
            }
        }

        // If no individual is selected (should not happen), return a random one
        return population.get(random.nextInt(population.size()));
    }
    public List<UniversityTimetable> crossover(UniversityTimetable parent1, UniversityTimetable parent2) {
        Random random = new Random();
        int numberOfClasses = parent1.getNumberOfClasses();
        // Create offspring timetables
        UniversityTimetable offspring1 = new UniversityTimetable(numberOfClasses);
        UniversityTimetable offspring2 = new UniversityTimetable(numberOfClasses);

        // Perform crossover for each class
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            List<ElementModule> parent1Timetable = parent1.getTimetable(classIndex);
            List<ElementModule> parent2Timetable = parent2.getTimetable(classIndex);

            int timetableSize = Math.min(parent1Timetable.size(), parent2Timetable.size());

            // Determine crossover point
            int crossoverPoint = 1; // Default to 1 if timetableSize <= 2
            if (timetableSize > 2) {
                // Adjust the range of the random number generator to exclude the first and last index
                crossoverPoint = random.nextInt(timetableSize - 2) + 1;
            }

            // If crossoverPoint is greater than the size of the parent timetables, set it to the size of the smaller parent timetable
            if (crossoverPoint > timetableSize) {
                crossoverPoint = timetableSize;
            }

            // Create child timetables by combining parent schedules
            List<ElementModule> child1Timetable = new ArrayList<>(parent1Timetable.subList(0, crossoverPoint));
            List<ElementModule> child2Timetable = new ArrayList<>(parent2Timetable.subList(0, crossoverPoint));

            List<ElementModule> remainingElementsParent1 = parent1Timetable.stream().filter(element -> !child2Timetable.contains(element)).toList();
            List<ElementModule> remainingElementsParent2 = parent2Timetable.stream().filter(element -> !child1Timetable.contains(element)).toList();

            // Add remaining elements from the other parent to each child timetable
            child1Timetable.addAll(remainingElementsParent2);
            child2Timetable.addAll(remainingElementsParent1);

            // Add child timetables to offspring
            offspring1.setTimetable(classIndex, child1Timetable);
            offspring2.setTimetable(classIndex, child2Timetable);
        }

        List<UniversityTimetable> offspring = new ArrayList<>();
        offspring.add(offspring1);
        offspring.add(offspring2);

        return offspring;
    }
    private void mutate(UniversityTimetable universityTimetable) {
        // Select a class to mutate
        int classIndex = random.nextInt(universityTimetable.getNumberOfClasses());
        List<ElementModule> classTimetable = universityTimetable.getTimetable(classIndex);
        // Select two positions in the class timetable
        int position1 = 0;
        int position2 = 0;
        if (classTimetable.size() > 0) {
            position1 = random.nextInt(classTimetable.size());
            position2 = random.nextInt(classTimetable.size());
        }
        // Randomly reassign day and period for the element in the updated timetable
        DayOfWeek randomDay = getRandomDay();
        Period randomPeriod = getRandomPeriode(randomDay);
        if (!classTimetable.isEmpty()) {
            classTimetable.get(position1).setDayOfWeek(randomDay);
            classTimetable.get(position1).setPeriod(randomPeriod);
        }
        // Swap the elements at the selected positions
        universityTimetable.swapGenes(classIndex, position1, position2);

        // Select another individual to get the new timetable from
        int classIndex2 = random.nextInt(universityTimetable.getNumberOfClasses());
        List<ElementModule> classTimetable2 = universityTimetable.getTimetable(classIndex2);
        // Replace the timetable of the selected class with the timetable from the second individual
        universityTimetable.setTimetable(classIndex, classTimetable2);


    }
    public UniversityTimetable generateTimetable() {
        initializePopulation();
        evolve();

        return getBestTimetable();
        //System.out.println("****************** individual best *******************");
        //printTimetable(bestSchoolTimetable);
    }

}



