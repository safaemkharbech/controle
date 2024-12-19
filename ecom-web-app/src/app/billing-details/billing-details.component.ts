import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billing-details',
  templateUrl: './billing-details.component.html',
  styleUrl: './billing-details.component.css'
})
export class BillingDetailsComponent implements OnInit{
  billingdetails : any;
  billId ! : any;
  constructor(private http:HttpClient , private router :Router , private activatedroute :ActivatedRoute) {
    this.billId = activatedroute.snapshot.params['billId']

  }
  ngOnInit(): void {

    this.http.get("http://localhost:8888/BILLING-SERVICE/fullbill/"+this.billId)
      .subscribe(
        {
          next : data =>{
            this.billingdetails = data;
          },
          error : err => {

          }
        }
      );
  }


}
