package storitz

import com.storitz.PressRelease

class StaticController {

  def privacy = {
    [title: 'Storitz Privacy Policy']
  }

  def terms = {
    [title: 'Storitz Terms of Use']
  }

  def faq = {
    [title: 'Storitz Frequently Asked Questions']
  }

  def aboutus = {
    params.max = 10
    params.sort = 'releaseDate'
    params.order = 'desc'
    [pressReleases:PressRelease.list(params)]
  }

  def refund = {
    [title: 'Storitz Refund Policy']
  }

  def jobs = {
    [title: 'Jobs and Careers at Storitz']
  }

  def operatorsignup = {
    [title: 'Storitz Operator Signup and Information']
  }

  def media = {
    [title: 'Storitz Press Room']
  }

  def guarantee = {
    [title: 'Storitz Guarantee']
  }

  def supports = {
    [title: 'Storitz Supports']
  }

  def collegerebate = {
     [title: 'Storitz College Storage Rebate Form']
  }

  def contestrules = {
     [title: 'Contest Rules and Regulations']
  }

  def customerservice = {
    [title: 'Help for Self-Storage Customers from Storitz.com']
  }
}
