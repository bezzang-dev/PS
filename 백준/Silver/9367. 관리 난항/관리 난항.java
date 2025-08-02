import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 자동차 정보를 저장하는 클래스
    static class Car {
        int price, initialFee, kmFee;
        Car(int p, int q, int k) {
            this.price = p;
            this.initialFee = q;
            this.kmFee = k;
        }
    }

    // 첩보원의 현재 렌탈 상태를 저장하는 클래스
    static class SpyState {
        boolean isRenting = false;
        String carName;
        int totalCost = 0;
        boolean inconsistent = false;

        void rent(String carName, int initialFee) {
            this.isRenting = true;
            this.carName = carName;
            this.totalCost += initialFee;
        }

        void processReturn(int distance, int kmFee) {
            this.isRenting = false;
            this.carName = null;
            this.totalCost += distance * kmFee;
        }

        void processAccident(double damageCost) {
            // 수리비는 올림 처리
            this.totalCost += Math.ceil(damageCost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수 읽기

        StringBuilder finalOutput = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 자동차 종류 수
            int m = Integer.parseInt(st.nextToken()); // 사건 로그 수

            Map<String, Car> carInfos = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String carName = st.nextToken();
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                carInfos.put(carName, new Car(p, q, k));
            }

            // 첩보원 이름(String)을 키로, 첩보원의 상태(SpyState)를 값으로 저장
            Map<String, SpyState> spies = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 시간 정보는 이 문제의 논리에서는 사용되지 않음
                String spyName = st.nextToken();
                char eventType = st.nextToken().charAt(0);

                // 첩보원 정보가 없으면 새로 생성
                spies.putIfAbsent(spyName, new SpyState());
                SpyState currentSpy = spies.get(spyName);

                // 이미 비일관성으로 판명된 첩보원은 더 이상 처리하지 않음
                if (currentSpy.inconsistent) {
                    continue;
                }

                switch (eventType) {
                    case 'p': // Pick-up
                        String carName = st.nextToken();
                        // 이미 다른 차를 빌리고 있다면 비일관성
                        if (currentSpy.isRenting) {
                            currentSpy.inconsistent = true;
                        } else {
                            Car car = carInfos.get(carName);
                            currentSpy.rent(carName, car.initialFee);
                        }
                        break;

                    case 'r': // Return
                        int distance = Integer.parseInt(st.nextToken());
                        // 빌린 차가 없는데 반납하면 비일관성
                        if (!currentSpy.isRenting) {
                            currentSpy.inconsistent = true;
                        } else {
                            Car car = carInfos.get(currentSpy.carName);
                            currentSpy.processReturn(distance, car.kmFee);
                        }
                        break;

                    case 'a': // Accident
                        int severity = Integer.parseInt(st.nextToken());
                        // 빌린 차가 없는데 사고를 내면 비일관성
                        if (!currentSpy.isRenting) {
                            currentSpy.inconsistent = true;
                        } else {
                            Car car = carInfos.get(currentSpy.carName);
                            // 수리비 = 원가 * (파손율 / 100.0)
                            double damageCost = (double) (car.price * severity) / 100;
                            currentSpy.processAccident(damageCost);
                        }
                        break;
                }
            }

            // 모든 이벤트를 처리한 후, 여전히 차를 빌리고 있는 첩보원은 비일관성
            for (SpyState spy : spies.values()) {
                if (spy.isRenting) {
                    spy.inconsistent = true;
                }
            }

            // 결과 출력
            for (Map.Entry<String, SpyState> entry : spies.entrySet()) {
                String spyName = entry.getKey();
                SpyState spyState = entry.getValue();

                finalOutput.append(spyName).append(" ");
                if (spyState.inconsistent) {
                    finalOutput.append("INCONSISTENT\n");
                } else {
                    finalOutput.append(spyState.totalCost).append("\n");
                }
            }
        }
        System.out.print(finalOutput);
    }
}