//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import dto.DTO;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import Servicios.PhInterface;
import Servicios.Servicio;

public class MainPhysics {
    public MainPhysics() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Double F1 = null;
        Double F2 = null;
        Double F3 = null;
        Double F3x = null;
        Double F3y = null;
        Double FR = null;
        double tetaFRf = 0.0;
        Double FRx = null;
        Double FRy = null;
        double k = 9.0E9;
        Scanner s = new Scanner(System.in);
        PhInterface repo = new Servicio();

        while(true) {
            while(true) {
                System.out.println("Welcome. Please enter the option you require. \n 1. Square \n 2.Record");
                switch (s.next()) {
                    case "1":
                        System.out.println("Enter the value of Q1");
                        Integer Q1 = Integer.parseInt(s.next());
                        System.out.println("Enter the value of Q2");
                        Integer Q2 = Integer.parseInt(s.next());
                        System.out.println("Enter the value of Q3");
                        Integer Q3 = Integer.parseInt(s.next());
                        System.out.println("Enter the value of Q4");
                        Integer Q4 = Integer.parseInt(s.next());
                        System.out.println("Enter the length of one side (In meters)    ");
                        Double longitud = Double.parseDouble(s.next());
                        Integer angulo2 = 45;
                        System.out.println("Choose the electric charge you will work with \n1.Q1\n2.Q2\n3.Q3\n4.Q4");
                        Double tetaFR;
                        switch (s.next()) {
                            case "1":
                                if (Q1 > 0) {
                                    if (Q2 > 0) {
                                        F1 = k * -((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    } else if (Q2 < 0) {
                                        F1 = k * ((double)Math.abs(Q2 * Q1) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F2 = k * ((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    } else if (Q3 < 0) {
                                        F2 = k * -((double)Math.abs(Q3 * Q1) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q4 > 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    } else if (Q4 < 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    }
                                } else if (Q1 < 0) {
                                    if (Q2 > 0) {
                                        F1 = k * ((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    } else if (Q2 < 0) {
                                        F1 = k * -((double)Math.abs(Q2 * Q1) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F2 = k * -((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    } else if (Q3 < 0) {
                                        F2 = k * ((double)Math.abs(Q3 * Q1) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q4 > 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    } else if (Q4 < 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * -F3;
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    }
                                }

                                FRx = F1 + 0.0 + F3x;
                                FRy = 0.0 + F2 + F3y;
                                FR = Math.sqrt(Math.pow(FRx, 2.0) + Math.pow(FRy, 2.0));
                                tetaFR = Math.toDegrees(Math.abs(Math.atan(FRy / FRx)));
                                if (FRy > 0.0 && FRx > 0.0) {
                                    tetaFRf = tetaFR;
                                } else if (FRy < 0.0 && FRx > 0.0) {
                                    tetaFRf = 270.0 + tetaFR;
                                } else if (FRy > 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 - tetaFR;
                                } else if (FRy < 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 + tetaFR;
                                }

                                System.out.println("The resultant vector is: (" + FRx + "," + FRy + ") \n RV magnitude: " + FR + " RV direction: " + tetaFRf);
                                repo.save(new DTO(Q1, Q2, Q3, Q4, F1, F2, F3, FR, tetaFRf, FRx, FRy, angulo2, longitud));
                                continue;
                            case "2":
                                if (Q2 > 0) {
                                    if (Q1 > 0) {
                                        F1 = k * ((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    } else if (Q1 < 0) {
                                        F1 = k * -((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    } else if (Q3 < 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    }

                                    if (Q4 > 0) {
                                        F2 = k * ((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q4 < 0) {
                                        F2 = k * -((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                } else if (Q2 < 0) {
                                    if (Q1 > 0) {
                                        F1 = k * -((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    } else if (Q1 < 0) {
                                        F1 = k * ((double)Math.abs(Q1 * Q2) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    } else if (Q3 < 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    }

                                    if (Q4 > 0) {
                                        F2 = k * ((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q4 < 0) {
                                        F2 = k * ((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                }

                                FRx = F1 + 0.0 + F3x;
                                FRy = 0.0 + F2 + F3y;
                                FR = Math.sqrt(Math.pow(FRx, 2.0) + Math.pow(FRy, 2.0));
                                tetaFR = Math.toDegrees(Math.abs(Math.atan(FRy / FRx)));
                                if (FRy > 0.0 && FRx > 0.0) {
                                    tetaFRf = tetaFR;
                                } else if (FRy < 0.0 && FRx > 0.0) {
                                    tetaFRf = 270.0 + tetaFR;
                                } else if (FRy > 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 - tetaFR;
                                } else if (FRy < 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 + tetaFR;
                                }

                                System.out.println("The resultant vector is: (" + FRx + "," + FRy + ") \n RV magnitude: " + FR + " RV direction: " + tetaFRf);
                                repo.save(new DTO(Q1, Q2, Q3, Q4, F1, F2, F3, FR, tetaFRf, FRx, FRy, angulo2, longitud));
                                continue;
                            case "3":
                                if (Q3 > 0) {
                                    if (Q1 > 0) {
                                        F1 = k * -((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    } else if (Q1 < 0) {
                                        F1 = k * ((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q2 > 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    } else if (Q2 < 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    }

                                    if (Q4 > 0) {
                                        F2 = k * -((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q4 < 0) {
                                        F2 = k * ((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                } else if (Q3 < 0) {
                                    if (Q1 > 0) {
                                        F1 = k * ((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    } else if (Q1 < 0) {
                                        F1 = k * -((double)Math.abs(Q1 * Q3) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q2 > 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    } else if (Q2 < 0) {
                                        F3 = k * ((double)Math.abs(Q2 * Q3) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    }

                                    if (Q4 > 0) {
                                        F2 = k * ((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q4 < 0) {
                                        F2 = k * -((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                }

                                FRx = 0.0 + F2 + F3x;
                                FRy = F1 + 0.0 + F3y;
                                FR = Math.sqrt(Math.pow(FRx, 2.0) + Math.pow(FRy, 2.0));
                                tetaFR = Math.toDegrees(Math.abs(Math.atan(FRy / FRx)));
                                if (FRy > 0.0 && FRx > 0.0) {
                                    tetaFRf = tetaFR;
                                } else if (FRy < 0.0 && FRx > 0.0) {
                                    tetaFRf = 270.0 + tetaFR;
                                } else if (FRy > 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 - tetaFR;
                                } else if (FRy < 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 + tetaFR;
                                }

                                System.out.println("The resultant vector is: (" + FRx + "," + FRy + ") \n RV magnitude: " + FR + " RV direction: " + tetaFRf);
                                repo.save(new DTO(Q1, Q2, Q3, Q4, F1, F2, F3, FR, tetaFRf, FRx, FRy, angulo2, longitud));
                                continue;
                            case "4":
                                if (Q4 > 0) {
                                    if (Q1 > 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    } else if (Q1 < 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    }

                                    if (Q2 > 0) {
                                        F2 = k * -((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q2 < 0) {
                                        F2 = k * ((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F1 = k * ((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q3 < 0) {
                                        F1 = k * -((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                } else if (Q4 < 0) {
                                    if (Q1 > 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = -(Math.cos(Math.toRadians((double)angulo2)) * F3);
                                        F3y = Math.sin(Math.toRadians((double)angulo2)) * F3;
                                    } else if (Q1 < 0) {
                                        F3 = k * ((double)Math.abs(Q1 * Q4) / Math.pow(longitud, 2.0));
                                        F3x = Math.cos(Math.toRadians((double)angulo2)) * F3;
                                        F3y = -(Math.sin(Math.toRadians((double)angulo2)) * F3);
                                    }

                                    if (Q2 > 0) {
                                        F2 = k * ((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q2 < 0) {
                                        F2 = k * -((double)Math.abs(Q2 * Q4) / Math.pow(longitud, 2.0));
                                    }

                                    if (Q3 > 0) {
                                        F1 = k * -((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    } else if (Q3 < 0) {
                                        F1 = k * ((double)Math.abs(Q3 * Q4) / Math.pow(longitud, 2.0));
                                    }
                                }

                                FRx = F1 + 0.0 + F3x;
                                FRy = 0.0 + F2 + F3y;
                                FR = Math.sqrt(Math.pow(FRx, 2.0) + Math.pow(FRy, 2.0));
                                tetaFR = Math.toDegrees(Math.abs(Math.atan(FRy / FRx)));
                                if (FRy > 0.0 && FRx > 0.0) {
                                    tetaFRf = tetaFR;
                                } else if (FRy < 0.0 && FRx > 0.0) {
                                    tetaFRf = 270.0 + tetaFR;
                                } else if (FRy > 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 - tetaFR;
                                } else if (FRy < 0.0 && FRx < 0.0) {
                                    tetaFRf = 180.0 + tetaFR;
                                }

                                System.out.println("The resultant vector is: (" + FRx + "," + FRy + ") \n RV magnitude: " + FR + " RV magnitude: " + tetaFRf);
                                repo.save(new DTO(Q1, Q2, Q3, Q4, F1, F2, F3, FR, tetaFRf, FRx, FRy, angulo2, longitud));
                            default:
                                continue;
                        }
                    case "2":
                        List<DTO> historial = repo.findAll();
                        if (!historial.isEmpty()) {
                            System.out.println("The calculator's history is as follows.");
                            PrintStream var10001 = System.out;
                            Objects.requireNonNull(var10001);
                            historial.forEach(var10001::println);
                        } else {
                            System.out.println("There´s no calculator's history yet.");
                        }
                }
            }
        }
    }
}
