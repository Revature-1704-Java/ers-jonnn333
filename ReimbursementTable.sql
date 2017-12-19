-- Reimbursements Table 

-- DROP TABLE Reimbursements;

CREATE TABLE Reimbursements (
  EmployeeID varchar2(255),
  ReimburseLimit number default 1000,
  RequestApproval number(1, 0) default 0,
  Attachments BLOB default NULL,
  SupervisorApproval number(1,0) default 0,
  SupervisorReason varchar(255) default NULL,
  DateLastModified timestamp default NULL
);

INSERT INTO Reimbursements(EmployeeID) VALUES ('EDF69ILV');
INSERT INTO Reimbursements(EmployeeID) VALUES ('FPE97HUF');
INSERT INTO Reimbursements(EmployeeID) VALUES ('TEF10DXP');
INSERT INTO Reimbursements(EmployeeID) VALUES ('VST14SGA');
INSERT INTO Reimbursements(EmployeeID) VALUES ('PVP33HDI');
INSERT INTO Reimbursements(EmployeeID) VALUES ('GGR16SRK');
INSERT INTO Reimbursements(EmployeeID) VALUES ('IOP25GLA');
INSERT INTO Reimbursements(EmployeeID) VALUES ('XGQ28GWY');
INSERT INTO Reimbursements(EmployeeID) VALUES ('FMD31OWB');
INSERT INTO Reimbursements(EmployeeID) VALUES ('BZT87QMK');
INSERT INTO Reimbursements(EmployeeID) VALUES ('DNE24PRX');
INSERT INTO Reimbursements(EmployeeID) VALUES ('IGZ35NCO');
INSERT INTO Reimbursements(EmployeeID) VALUES ('GBI96MBE');
INSERT INTO Reimbursements(EmployeeID) VALUES ('QAG54TCF');
INSERT INTO Reimbursements(EmployeeID) VALUES ('JSW63CQY');
INSERT INTO Reimbursements(EmployeeID) VALUES ('HIV35TKD');
INSERT INTO Reimbursements(EmployeeID) VALUES ('WUW85BYI');
INSERT INTO Reimbursements(EmployeeID) VALUES ('LZY01KYX');
INSERT INTO Reimbursements(EmployeeID) VALUES ('OHI66YEZ');
INSERT INTO Reimbursements(EmployeeID) VALUES ('EAF54QRB');
INSERT INTO Reimbursements(EmployeeID) VALUES ('DWM18MQE');
INSERT INTO Reimbursements(EmployeeID) VALUES ('HJT24KWV');
INSERT INTO Reimbursements(EmployeeID) VALUES ('RKT28AKZ');
INSERT INTO Reimbursements(EmployeeID) VALUES ('PFX25XXM');
INSERT INTO Reimbursements(EmployeeID) VALUES ('LXJ19BDJ');