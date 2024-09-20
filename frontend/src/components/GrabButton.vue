<template>
  <div class="container">
    <button @click="getConsumption" class="blue-button">Get Consumption</button>
  </div>
</template>

<script>
export default {
  name: 'ConsumptionButton',
  data() {
    return {
      message: ''
    };
  },
  methods: {
    async getConsumption() {  // Changed method name to getConsumption
      try {
        const response = await fetch('http://localhost:8080/greeting?name=test');
        const data = await response.json();
        this.message = data.message;  // assuming backend returns a message
      } catch (error) {
        console.error('Error fetching consumption:', error);
        this.message = 'Failed to fetch consumption';
      }
    }
  }
}
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Full screen height */
  background-color: #f5f5f5; /* Light gray background */
}

.blue-button {
  background-color: #007bff; /* Beautiful blue color */
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s ease;
}

.blue-button:hover {
  background-color: #0056b3; /* Darker blue on hover */
}
</style>
