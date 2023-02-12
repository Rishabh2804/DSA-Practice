class Solution {
    
    static class Car{
        long fuel;
        int passengers;
        
        public Car(long fuel, int passengers){
            this.fuel = fuel;
            this.passengers = passengers;
        }
    }
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        return dfs(0, -1, adj, seats).fuel;
    }
    
    public Car dfs(int city, int prev, List<List<Integer>> adj, int seats){

        long fuel = 0;
        int passengers = 1;
        
        for(int neighbour : adj.get(city)){
            if(neighbour == prev)
                continue;
            
            Car guestCar = dfs(neighbour, city, adj, seats);
            
            passengers += guestCar.passengers;
            int numCars = (guestCar.passengers / seats);
            if(guestCar.passengers % seats != 0)
                numCars ++;

            fuel += guestCar.fuel + numCars;  
            // System.out.println(city + " " + guestCar.fuel + " " + guestCar.passengers);
        }
        
        return new Car(fuel, passengers);
    }
}

// fuel
// passengers
