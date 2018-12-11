import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from '../model/utilisateur'
import {Patient} from '../model/patient';
import {PatientDonneesUtilisateurHttpService} from './patient-donnees-utilisateur-http.service';

@Component({
  selector: 'app-patient-donnees-utilisateur',
  templateUrl: './patient-donnees-utilisateur.component.html',
  styleUrls: ['./patient-donnees-utilisateur.component.css']
})
export class PatientDonneesUtilisateurComponent implements OnInit {

  @Input()
  utilisateurId: number;

  affiche: boolean = false;
  current: Patient = new Patient();

  constructor(private patientDonneesUtilisateurService: PatientDonneesUtilisateurHttpService) {
  }

  ngOnInit() {
    this.patientDonneesUtilisateurService.findPatientDefaut(this.utilisateurId).subscribe(resp => {
      this.current = resp.json();
      console.log(this.current);
    }, err => console.log(err));
  }

  edit() {
    this.affiche = true;
  }

  save() {
    this.patientDonneesUtilisateurService.save(this.current.id, this.current).subscribe(resp => {
      this.current = resp.json();
      console.log(this.current);
    }, err => console.log(err));
    this.affiche = false;
  }

  cancel() {
    this.affiche = false;
  }

}
