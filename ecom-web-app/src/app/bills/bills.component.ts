import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit{
  bills : any;
  customerId ! : any;
  constructor(private http:HttpClient , private router :Router , private activatedroute :ActivatedRoute) {
    this.customerId = activatedroute.snapshot.params['customerId']

  }
  ngOnInit(): void {

    this.http.get("http://localhost:8888/BILLING-SERVICE/bills/search/byCustomerId?&projection=fullbilling&customerId="+this.customerId)
      .subscribe(
      {
        next : data =>{
          this.bills = data;
        },
        error : err => {

        }
      }
    );
  }

  getBillDetails(b: any) {
      this.router.navigateByUrl("/billing-details/"+b.id);
  }
}
