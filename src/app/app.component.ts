import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'forecast';
  zipCode: string = '';
  weatherData: any;

  constructor(private http: HttpClient) { }

  getForecast() {
    const zipCodeInput: HTMLInputElement = document.getElementById("zipCodeInput") as HTMLInputElement;
    const aZipCode: string = zipCodeInput.value;
    this.zipCode = aZipCode;
    this.http.get<any>('http://localhost:8080/weather?zipCode=' + this.zipCode)
      .subscribe(data => {
        this.weatherData = data;
      }, error => {
        console.error('Error:', error);
        document.getElementById("weatherResult")!.innerHTML = "Error: invalid zip code";
      });
  }
}
